
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class VipCustomermanager extends Abstract {

    Scanner sc = new Scanner(System.in);
    private static final String EMAIL_REGEX = "^[A-ZA-Z0-9_+&*-]+\\._EMAIL_REGEX[]A-Za-z0-9_+&*-]+)*@" + "(?:[A-Za-z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean emailValidate(String gmail) {
        if (gmail == null) {
            return false;
        }
        Matcher validate = EMAIL_PATTERN.matcher(gmail);
        return validate.matches();
    }

    @Override
    public void add() {
        String phone = "Missing", id = "Missing", name = "Missing";
        String mail = "Missing";
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

        System.out.print("discount rate: ");
        double discountRate = sc.nextDouble();

        System.out.print("delete: ");
        int isDelete = sc.nextInt();

        sc.nextLine();

        try {
            FileWriter w = new FileWriter("data.text", true);
            w.write(String.format("%-10s|%-25s|%-15s|%-25s|%-7d|%-13.2f|\n", id, name, phone, mail, isDelete, discountRate));
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
                    System.out.println("3.change discount rate");
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
                                if (emailValidate(email) != false) {
                                    if (data[3].equalsIgnoreCase(email)) {
                                        System.out.println("New email cannot be same as old!!");
                                    } else {
                                        break;
                                    }
                                }
                            }
                            data[3] = String.format("%-25s", email);
                            break;
                        case 3:
                            System.out.print("new Discount Rate: ");
                            double discountRate = Double.parseDouble(sc.nextLine());
                            data[4] = String.format("%-10.2f", discountRate);
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
        String searchId = "";
        while(true){
        System.out.print("chooseId: ");
        searchId = sc.nextLine();
        if (searchId != null){
            break;
        }
        }
        boolean find = false;

        ArrayList<String> fileContent = new ArrayList<>();

        try ( BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
            String line;

            while ((line = r.readLine()) != null) {
                if (line.trim().startsWith(searchId.trim())) {
                    find = true;
                    String[] parts = line.split("\\|");
                    String currentStatus = parts[5].trim();

                    if (currentStatus.equals("0")) {
                        line = line.replace("|" + parts[5] + "|", "|" + parts[5].replace("0", "1") + "|");
                        System.out.println("Deleted successfully (Status changed to 1)!");
                    } else {
                        line = line.replace("|" + parts[5] + "|", "|" + parts[5].replace("1", "0") + "|");
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
        String searchId = "";
        while(true){
        System.out.print("chooseId: ");
        searchId = sc.nextLine();
        if (searchId != null){
            break;
        }
        }
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
