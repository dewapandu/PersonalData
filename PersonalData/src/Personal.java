import java.util.Scanner;
public class Personal {
    static String[] personalInfo = new String[6];
    public static void main(String[] args) {
        int no = 0;
        Scanner input = new Scanner(System.in);
        String choice = "";
        String name, dob, noHp;
        System.out.println("========= Pengisian Data Diri =========");

        do{
            System.out.println("Masukkan nama lengkap : ");
            name = input.nextLine();
            System.out.println("Masukkan tanggal lahir : ");
            dob = input.nextLine();
            System.out.println("Masukkan nomor handphone : ");
            noHp = input.nextLine();

            do{
                if(no > 0 && !choice.matches("[nN]")){
                    System.out.println("Jawab dengan [Y/N] atau [y/n]");
                }
                System.out.println("Apakah Anda yakin dengan data tersebut ? [Y/N] : ");
                choice = input.nextLine();
                no++;
            }while(!choice.matches("[nNyY]"));

        }while(!choice.matches("[yY]"));

        personalInfo[0] = name.isEmpty() ? "-" : name;
        personalInfo[1] = "-";
        personalInfo[2] = noHp.isEmpty() ? "-" : noHp;
        personalInfo[3] = dob.isEmpty() ? "-" : dob;
        personalInfo[4] = "-";
        personalInfo[5] = "-";
        menu();
    }

    public static void menu(){
        Scanner input = new Scanner(System.in);
        String chooseMenu;
        System.out.println("==================================");
        System.out.println("Pilih menu di bawah ini :");
        System.out.println("1. Lihat Data Diri");
        System.out.println("2. Update Data Diri");
        System.out.println("3. Keluar");
        System.out.println("==================================");
        System.out.println("Pilihan [1/2/3] : ");
        do {
            chooseMenu = input.nextLine();
            if(!chooseMenu.matches("[123]")){
                System.out.println("Jawab dengan memilih [1/2/3]");
            }
        } while (!chooseMenu.matches("[123]"));

        switch(chooseMenu){
            case "1":
                getPersonal();
                break;
            case "2":
                chooseFieldPersonal();
                break;
            case "3":
                System.exit(-1);
                break;
            default:
                break;
        }
    }

    public static void getPersonal(){
        System.out.println("Nama            : " + personalInfo[0]);
        System.out.println("Alamat          : " + personalInfo[1]);
        System.out.println("Nomor Handphone : " + personalInfo[2]);
        System.out.println("Tanggal Lahir   : " + personalInfo[3]);
        System.out.println("Status          : " + personalInfo[4]);
        System.out.println("Nomor KTP       : " + personalInfo[5]);
        System.out.println("Tekan enter untuk kembali ke menu utama . . .");
        try{System.in.read();}
        catch(Exception e){}
        menu();
    }

    public static void chooseFieldPersonal(){
        Scanner input = new Scanner(System.in);
        String chooseUpdate;
        System.out.println("Pilih data yang ingin diupdate :");
        System.out.println("1. Nama");
        System.out.println("2. Alamat");
        System.out.println("3. Nomor Handphone");
        System.out.println("4. Tanggal Lahir");
        System.out.println("5. Status");
        System.out.println("6. Nomor KTP");
        System.out.println("7. Cancel");
        System.out.println("==================================");
        System.out.println("Pilihan [1/2/3/4/5/6/7] : ");
        do {
            chooseUpdate = input.nextLine();
            if(!chooseUpdate.matches("[1234567]")){
                System.out.println("Jawab dengan memilih [1/2/3/4/5/6/7]");
            }
        } while (!chooseUpdate.matches("[1234567]"));
        switch (chooseUpdate){
            case "1":
                updatePersonal(0, "nama lengkap");
                break;
            case "2":
                updatePersonal(1, "alamat");
                break;
            case "3":
                updatePersonal(2, "nomor handphone");
                break;
            case "4":
                updatePersonal(3, "tanggal lahir");
                break;
            case "5":
                updatePersonal(4, "status");
                break;
            case "6":
                updatePersonal(5, "nomor ktp");
                break;
            default:
                menu();
                break;
        }
    }

    public static void updatePersonal(int attributeIndex, String attribute){
        String updateData;
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan " + attribute + (attributeIndex == 4 ? " [Belum Kawin/Kawin]" : "") + " : ");
        updateData = input.nextLine();
        personalInfo[attributeIndex] = updateData.isEmpty() ? "-" : updateData;
        System.out.println("Data " + attribute + " Anda berhasil diperbarui.");
        System.out.println("Tekan enter untuk kembali ke menu utama. . . ");
        try{System.in.read();}
        catch(Exception e){}
        menu();
    }
}
