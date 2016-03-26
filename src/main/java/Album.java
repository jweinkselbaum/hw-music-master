public class Album {
    private String title;
    private String artist;
    private Song[] songs = new Song[1];
    private int numSongs;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Song[] getSongs() {
        return songs;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public void addSong(Song s) {
        for (int i = 0; i < this.songs.length; i++) {
            if (songs[i] == null) {
                songs[i] = s;
                numSongs += 1;
            } else if (i == this.songs.length - 1 && songs[i] != null) {
                Song[] tempSongs = new Song[this.songs.length * 2];
                int notNull = 0;
                int oldSongsLength = this.songs.length;
                for (int j = 0; j < this.songs.length; j++) {
                    tempSongs[j] = songs[j];
                }
                this.songs = tempSongs;
                this.songs[oldSongsLength] = s;
                for (int k = 0; k < this.songs.length; k++) {
                    if (this.songs[k] != null) {
                        notNull += 1;
                    }
                }
                Song[] tempSongs2 = new Song[notNull];
                for (int l = 0; l < tempSongs2.length; l++) {
                    tempSongs2[l] = this.songs[l];
                }
                this.songs = tempSongs2;
                numSongs += 1;
                break;
            }
        }
    }

    public String toString() {
        return title + " - " + artist;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
}
