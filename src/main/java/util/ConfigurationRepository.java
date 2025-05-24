package util;

import lombok.Getter;
import repository.LocalRepository;
import repository.MathesRepository;
import repository.PlayersRepository;

public class ConfigurationRepository {


    private static ConfigurationRepository instance;


    private final LocalRepository localRepository;

    private final PlayersRepository playersRepository;

    private final MathesRepository mathesRepository;

    private ConfigurationRepository() {
        this.localRepository = new LocalRepository();
        this.playersRepository = new PlayersRepository();
        this.mathesRepository = new MathesRepository();
    }

    public static ConfigurationRepository getInstance() {
        if (instance == null) {
            instance = new ConfigurationRepository();
        }
        return instance;
    }

    public PlayersRepository getPlayersRepository() {
        return playersRepository;
    }

    public LocalRepository getLocalRepository() {
        return localRepository;
    }

    public MathesRepository getMathesRepository() {
        return mathesRepository;
    }
}
