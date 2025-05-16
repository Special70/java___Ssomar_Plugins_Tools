package org.sptools.ssomar_plugins_tools.lib.functions;


import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * The purpose of this class is to shorten code when reading
 * each file and each of its activators.
 *
 * The main function class would use a for-loop and pass the target path
 * and this static function would return a Map object
 */
public class YamlFileLoader {
    public static Map<String, Object> getValidFile(File fileArg) {
        Map<String, Object> loadedYMLFile = null;
        try {
            // Reading yml files and saving it in a Map
            InputStream inputStream = new FileInputStream(fileArg);
            Yaml yaml = new Yaml();
            loadedYMLFile = yaml.load(inputStream);


        } catch (Exception e) {

        }
        return loadedYMLFile;
    }
}