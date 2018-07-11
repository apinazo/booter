package es.apinazo.booter.git;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Gets and shows info from the git versioning of the application,
 * generated when it is build and/or packaged. Info is located in
 * the target/classes/git.properties file.
 */
@RestController
@RequestMapping("/git")
public class GitInfoController {

    @GetMapping("/info")
    public String versionInformation() {

        ClassLoader classLoader = getClass().getClassLoader();

        // Get the git.properties file in the classpath.
        File file = new File(classLoader.getResource("git.properties").getFile());

        String info;

        try {
            // Using FileUtils avoids boilerplate code with InputStream, BufferedReader and so.
            info = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            info = "No info could be retrieved";
        }

        return info;
    }

}
