
import Main.Report;
import Main.Transaction;
import java.util.ArrayList;

//test manager: 

class Main
{
    public static void main(String[] args)
    {
        VipCustomermanager nc = new VipCustomermanager();
        nc.add();
         
    }
    
}


// test transaction:
//public class Main {
//    public static void main(String[] args) 
//    {
//        
//        ArrayList<Transaction> listTransaction = new ArrayList<>();
//        Transaction t1 = new Transaction("PROD001", "Nguyễn Văn A", 3);
//        Transaction t2 = new Transaction("PROD002", "Trần Thị B", 1);
//        Transaction t3 = new Transaction("PROD005", "Khách VIP 01", 10);
//        listTransaction.add(t1);
//        listTransaction.add(t2);
//        listTransaction.add(t3);
//        System.out.printf("| %-10s | %-20s | %-8s | %-20s |\n", "Mã SP", "Tên Khách Hàng", "S.Lượng", "Thời Gian Giao Dịch");
//        for (Transaction t : listTransaction) {
//            System.out.printf("| %-10s | %-20s | %-8d | %-20s |\n", t.getProductId(), t.getName(), t.getQuantity(), t.getTimestamp());
//        }
       
//        System.out.println("\nThời gian của giao dịch thứ nhất là: " + t1.getTimestamp());
//    }
//}


// test report:
//public class Main {
//    public static void main(String[] args) {
//        Report storeReport = new Report();
//        Transaction giaoDich1 = new Transaction("P001", "Nguyễn Văn A", 5);
//        Transaction giaoDich2 = new Transaction("P002", "Trần Thị B", 2);
//        Transaction giaoDich3 = new Transaction("P003", "Khách VIP 99", 10);
//        storeReport.addTransaction(giaoDich1);
//        storeReport.addTransaction(giaoDich2);
//        storeReport.addTransaction(giaoDich3);
//        storeReport.report();     
//    }
//}