package domain;

/**
 * Una canción que que se encuentra entre el ranking 10000.
 */
public class Song{
        
    private int position;
    private String artist;
    private String song;
    private int days; //Numero de días desde el lanzamiento de la canción
    private double top_10;
    private int peak_Position;
    private String peak_Position_xTimes;
    private int peak_Streams;
    private double total_Streams;

    

    /**
     * Contructor que crea un objeto Song.
     * 
     * @param position Ranking de la canción.
     * @param artist    Nombre del artista de la canción.
     * @param song      Nombre de la canción.
     * @param days      Días desde el lanzamiento de la canción.
     * @param top_10    Nº de veces dentro de la posición máxima de los 10 mejores.
     * @param peak_Position Posición máxima alcanzada.
     * @param peak_Position_xTimes Posición máxima (xTimes).
     * @param peak_Streams Número total de transmisiones durante la posición.
     * @param total_Streams Total de transmisiones de canciones.
     */
    public Song(int position, String artist, String song, int days, double top_10, int peak_Position, String peak_Position_xTimes, int peak_Streams, double total_Streams) {
        this.position = position;
        this.artist = artist;
        this.song = song;
        this.days = days;
        this.top_10 = top_10;
        this.peak_Position = peak_Position;
        this.peak_Position_xTimes = peak_Position_xTimes;
        this.peak_Streams = peak_Streams;
        this.total_Streams = total_Streams;
    }



    public int getPosition() {
        return position;
    }



    public void setPosition(int position) {
        this.position = position;
    }



    public String getArtist() {
        return artist;
    }



    public void setArtist(String artist) {
        this.artist = artist;
    }



    public String getSong() {
        return song;
    }



    public void setSong(String song) {
        this.song = song;
    }



    public int getDays() {
        return days;
    }



    public void setDays(int days) {
        this.days = days;
    }



    public double getTop_10() {
        return top_10;
    }



    public void setTop_10(double top_10) {
        this.top_10 = top_10;
    }



    public int getPeak_Position() {
        return peak_Position;
    }



    public void setPeak_Position(int peak_Position) {
        this.peak_Position = peak_Position;
    }



    public String getPeak_Position_xTimes() {
        return peak_Position_xTimes;
    }



    public void setPeak_Position_xTimes(String peak_Position_xTimes) {
        this.peak_Position_xTimes = peak_Position_xTimes;
    }



    public int getPeak_Streams() {
        return peak_Streams;
    }



    public void setPeak_Streams(int peak_Streams) {
        this.peak_Streams = peak_Streams;
    }



    public double getTotal_Streams() {
        return total_Streams;
    }



    public void setTotal_Streams(double total_Streams) {
        this.total_Streams = total_Streams;
    }
    
    
    

   

}
