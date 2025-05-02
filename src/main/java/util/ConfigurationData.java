package util;

import model.PlayersCurrentMathes;

import java.util.HashMap;
import java.util.UUID;

public class ConfigurationData {
    public HashMap<UUID, PlayersCurrentMathes> collectionCuurentMathes=new HashMap<>();

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
