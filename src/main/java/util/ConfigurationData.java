package util;

import model.Match;

import java.util.HashMap;
import java.util.UUID;

public class ConfigurationData {
    public HashMap<UUID, Match> collectionCuurentMathes=new HashMap<>();

    static ConfigurationData configurationData;

    private ConfigurationData(){

    }

    public static ConfigurationData getInstance(){
        if (configurationData == null){
            configurationData=new ConfigurationData();
        }
        return configurationData;
    }
}
