import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.poi.poifs.macros.VBAMacroExtractor;

import java.io.File;
import java.io.IOException;

/**
 * Tool, um VBA Makros automatisch aus Excel zu extrahieren, um sie als Sourcecode mit Historie einchecken zu können.
 */

@Mojo(name = "extract-vba", // this is the goal
      defaultPhase = LifecyclePhase.GENERATE_RESOURCES)  // the default phase
public class VBAMacroExtractorMavenPlugin extends AbstractMojo {

   @Parameter(required = true) private String sourceFilePath;

   @Parameter(required = true) private String targetDirPath;

   @Override public void execute() throws MojoExecutionException, MojoFailureException {
      try {
         new VBAMacroExtractor().extract(new File(sourceFilePath), new File(targetDirPath));
      } catch (IOException e) {
         throw new MojoExecutionException(e.getMessage(), e);
      }
   }

   public VBAMacroExtractorMavenPlugin withSourceFilePath(String sourceFilePath) {
      this.sourceFilePath = sourceFilePath;
      return this;
   }

   public VBAMacroExtractorMavenPlugin withTargetDirPath(String targetDirPath) {
      this.targetDirPath = targetDirPath;
      return this;
   }

   public static void main(String[] args) throws MojoExecutionException, MojoFailureException {
      new VBAMacroExtractorMavenPlugin().withSourceFilePath(args[0])
                                        .withTargetDirPath(args[1])
                                        .execute();
   }
}
