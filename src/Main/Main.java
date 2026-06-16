package Main;


import Main.Report;
import Main.Transaction;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//test manager: 
//class Main
//{
  //  public static void main(String[] args)
    //{
      // VipCustomermanager nc = new VipCustomermanager();
        //nc.add();
         
 //}
//}


// test transaction:
//public class Main
//{
//    public static void main(String[] args)
//    {
//        ArrayList<Transaction> listTransaction = new ArrayList<>();
//
//        Transaction t1 = new Transaction("PROD001", "Nguyễn Văn Mười", 3);
//        Transaction t2 = new Transaction("PROD002", "Trần Thị Tuyết Nhi", 1);
//        Transaction t3 = new Transaction("PROD005", "Nguyễn Đức Nhật Khang", 10);
//        listTransaction.add(t1);
//        listTransaction.add(t2);
//        listTransaction.add(t3);
//        t1.saveTransaction(t1);
//        t2.saveTransaction(t2);
//        t3.saveTransaction(t3);
//
//        System.out.println("Da luu vao file Transaction.text");
//    }
//}


// test report:
//public class Main {
//    public static void main(String[] args) {
//        try (BufferedReader read = new BufferedReader(new FileReader("Transaction.text"))) {
//            String line;
//            while ((line = read.readLine()) != null) {
//                System.out.println(line);
//            }
//            
//        } catch (IOException e) {
//            System.out.println("Lỗi: Khong tim thay file Transaction.text");
//        }
//    }
//}