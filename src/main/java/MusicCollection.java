import java.util.Scanner;
public class MusicCollection {

    private static Scanner keyboard = new Scanner(System.in);
    private static Album[] lstAlbums = new Album[3];
    private static Song[] songArr;
    private static int choice = 0;

    public Scanner getKeyboard() {
        return this.keyboard;
    }

    public Album[] getLstAlbums() {
        return this.lstAlbums;
    }

    public Song[] getSongArr() {
        return this.songArr;
    }

    public int getChoice() {
        return this.choice;
    }

    public static void choiceZero(Album albumName) {
        System.out.println();
        System.out.println("Enter title, artist [, genre]:");
        String pT = keyboard.nextLine();
        String newTitle = "";
        String newArtist = "";
        String newGenre = "";
        int firstComma = 0;
        int secondComma = 0;

        for (int i = 0; i < pT.length(); i++) {
            if ((pT.substring(i, i + 1)).contains(",") && firstComma == 0) {
                newTitle += pT.substring(0, i);
                firstComma = i;
                i++;
            }
            if (i == pT.length() - 1 && firstComma != 0) {
                newArtist += pT.substring(firstComma + 2);
            }
            if (((pT.substring(i, i + 1)).contains(",") && firstComma != 0 && i != pT.length() - 1)) {
                newArtist += pT.substring(firstComma + 2, i);
                secondComma = i;
                i++;
            }
            if (firstComma != 0 && secondComma != 0 && secondComma != pT.length() - 1) {
                newGenre += pT.substring(secondComma + 2);
                break;
            }
        }
        if (newGenre != "") {
            Song newSong = new Song(newTitle, newArtist, newGenre);
            albumName.addSong(newSong);
        } else {
            Song newSong = new Song(newTitle, newArtist);
            albumName.addSong(newSong);
        }
        System.out.println();
        choiceOne();
    }

    public static void choiceOne() {
        for (int i = 0; i < lstAlbums.length; i++) {
            System.out.println("[" + i + "]" + " " + lstAlbums[i]);
        }

        System.out.println("Which album number would you like to examine?");
        choice = Integer.parseInt(keyboard.nextLine());
        System.out.println();
        albumOptions(lstAlbums[choice]);
    }

    public static void albumOptions(Album albumName) {
        System.out.println(albumName);
        songArr = albumName.getSongs();
        for (int i = 0; i < songArr.length; i++) {
            System.out.println("\t" + songArr[i]);
        }
        System.out.println();
        System.out.println("[0] Add Song");
        System.out.println("[1] Go Back");
        System.out.println("Choose an option...");
        choice = Integer.parseInt(keyboard.nextLine());
        while (choice != -1) {
            if (choice == 0) {
                choiceZero(albumName);
            } else if (choice == 1) {
                choiceOne();
            }
        }
    }

    public static void main(String[] args) {

        Album theFame = new Album("The Fame", "Lady GaGa");
        lstAlbums[0] = theFame;
        Song justDance = new Song("Just Dance", "Lady GaGa", "Pop");
        Song pokerFace = new Song("Poker Face", "Lady GaGa", "Pop");
        theFame.addSong(justDance);
        theFame.addSong(pokerFace);

        Album nteen = new Album("1989", "Taylor Swift");
        lstAlbums[1] = nteen;
        Song shake = new Song("Shake It Off", "Taylor Swift", "Pop");
        Song style = new Song("Style", "Taylor Swift", "Pop");
        nteen.addSong(shake);
        nteen.addSong(style);

        Album prism = new Album("Prism", "Katy Perry");
        lstAlbums[2] = prism;
        Song roar = new Song("Roar", "Katy Perry", "Pop");
        Song ghost = new Song("Ghost", "Katy Perry", "Pop");
        prism.addSong(roar);
        prism.addSong(ghost);

        for (int i = 0; i < lstAlbums.length; i++) {
            System.out.println("[" + i + "]" + " " + lstAlbums[i]);
        }

        while (choice != -1) {
            System.out.println("Which album number would you like to examine?");
            choice = Integer.parseInt(keyboard.nextLine());
            System.out.println();

            albumOptions(lstAlbums[choice]);
        }
    }
}
