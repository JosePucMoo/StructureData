package domain;

public class Song{
        
    private String id;
    private String name;
    private double duration;
    private double energy;
    private int key;
    private double loudness;
    private int mode;
    private double speechiness;
    private double acousticness;
    private String instrumentalness;
    private String liveness;
    private String valence;
    private String tempo;
    private String danceability;


    

    public Song(String id, String name, double duration, double energy, int key, double loudness, int mode, double speechiness, double acousticness, String instrumentalness, String liveness, String valence, String tempo, String danceability) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.danceability = danceability;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public double getEnergy() {
        return energy;
    }
    public void setEnergy(double energy) {
        this.energy = energy;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public double getLoudness() {
        return loudness;
    }
    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }
    public int getMode() {
        return mode;
    }
    public void setMode(int mode) {
        this.mode = mode;
    }
    public double getSpeechiness() {
        return speechiness;
    }
    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }
    public double getAcousticness() {
        return acousticness;
    }
    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }
    public String getInstrumentalness() {
        return instrumentalness;
    }
    public void setInstrumentalness(String instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public String getLiveness() {
        return liveness;
    }

    public void setLiveness(String liveness) {
        this.liveness = liveness;
    }

    public String getValence() {
        return valence;
    }

    public void setValence(String valence) {
        this.valence = valence;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getDanceability() {
        return danceability;
    }

    public void setDanceability(String danceability) {
        this.danceability = danceability;
    }

    


    



}
