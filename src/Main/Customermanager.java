
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Customermanager extends Abstract {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    Scanner sc = new Scanner(System.in);
    
    public static boolean emailValidate(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    @Override
    public void add() {
        String name = "", id = "", phone = "", mail = "";

        while (true) {
            System.out.print("Id: ");
            id = sc.nextLine();
            if (id != null) {
                break;
            } else {
                System.out.println("Input cannot be void!!");
            }
        }

        while (true) {
            System.out.print("Name: ");
            name = sc.nextLine();
            if (name != null) {
                break;
            } else {
                System.out.println("Input cannot be void!!");
            }
        }

        while (true) {
            try {
                System.out.print("phone: ");
                phone = sc.nextLine();
                if (phone.length() == 10) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("[Error] Invalid input");
            }
        }
        while (true) {
            try {
                System.out.print("gmail: ");
                mail = sc.nextLine();
                if (emailValidate(mail) != false) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("[Error] Invalid email");
            }
        }
        System.out.print("delete: ");
        int isDelete = sc.nextInt();
        sc.nextLine();
        try {
            FileWriter w = new FileWriter("data.text", true);
            w.write(String.format("%-10s|%-25s|%-15s|%-25s|%-7d|\n", id, name, phone, mail, isDelete));
            w.close();
            System.out.println("Append success");
        } catch (IOException e) {
            System.out.println("Error!Access is denied");
        }
    }

    @Override
    public void update() {
        System.out.print("chooseId: ");
        String searchId = sc.nextLine().trim();
        boolean find = false;

        ArrayList<String> fileContent = new ArrayList<>();
        try ( BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
            String line;

            while ((line = r.readLine()) != null) {
                String[] data = line.split("\\|", -1);
                if (data.length > 0 && data[0].trim().equals(searchId)) {
                    find = true;

                    System.out.println("1.change phone");
                    System.out.println("2.change email");
                    System.out.print("choose your option: ");

                    int choose = Integer.parseInt(sc.nextLine());

                    switch (choose) {
                        case 1:
                            String phone = "Error";
                            while (true) {
                                System.out.print("new Phone: ");
                                phone = sc.nextLine();
                                if (phone.length() == 10) {
                                    if (data[2].equalsIgnoreCase(phone)) {
                                        System.out.println("New phone number cannot be same as old!!");
                                    } else {
                                        break;
                                    }
                                }
                            }
                            data[2] = String.format("%-15s", phone);
                            break;
                        case 2:
                            String email = "";
                            while (true) {
                                System.out.print("new Email: ");
                                email = sc.nextLine();
                                if(emailValidate(email)!=false){
                                    if(data[3].equalsIgnoreCase(email)){
                                        System.out.println("New email cannot be same as old!!");
                                    } else {
                                        break;
                                    }
                                }
                            }
                            data[3] = String.format("%-25s", email);
                            break;
                        default:
                            System.out.println("Invalid option!");
                            break;
                    }

                    line = String.join("|", data);
                }

                fileContent.add(line);
            }

            if (!find) {
                System.out.println("can't find ID !!!!");
                return;
            }

        } catch (IOException e) {
            System.out.println("Error reading file!");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            return;
        }
        try ( FileWriter w = new FileWriter("data.text", false)) {
            for (String updatedLine : fileContent) {
                w.write(updatedLine + "\n");
            }
            System.out.println("Update complete!");
        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

    @Override
    public void delete() {
        System.out.print("chooseId: ");
        String searchId = sc.nextLine();
        boolean find = false;

        ArrayList<String> fileContent = new ArrayList<>();

        try ( BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
            String line;

            while ((line = r.readLine()) != null) {
                if (line.trim().startsWith(searchId.trim())) {
                    find = true;
                    String[] parts = line.split("\\|");
                    String currentStatus = parts[4].trim();

                    if (currentStatus.equals("0")) {
                        line = line.replace("|" + parts[4] + "|", "|" + parts[4].replace("0", "1") + "|");
                        System.out.println("Deleted successfully (Status changed to 1)!");
                    } else {
                        line = line.replace("|" + parts[4] + "|", "|" + parts[4].replace("1", "0") + "|");
                        System.out.println("Restored successfully (Status changed to 0)!");
                    }
                }
                fileContent.add(line);
            }

            if (!find) {
                System.out.println("can't find ID !!!!");
                return;
            }

        } catch (IOException e) {
            System.out.println("error!!!can read file");
            return;
        }
        try ( FileWriter w = new FileWriter("data.text", false)) {
            for (String updatedLine : fileContent) {
                w.write(updatedLine + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

    @Override
    public void showInfor() {

        try ( BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Eror!! file not exist");
        }
    }

    @Override
    public void search() {
        System.out.print("chooseId: ");
        String searchId = sc.nextLine();
        boolean find = false;
        String search = searchId.trim() + "|";

        try ( BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
            String line;

            while ((line = r.readLine()) != null) {
                if (line.trim().startsWith(searchId.trim())) {
                    System.out.println(line);
                    find = true;
                    break;
                }
            }

            if (!find) {
                System.out.println("can't find ID !!!!");
            }

        } catch (IOException e) {
            System.out.println("error!!!can read file");
        }
    }
}
