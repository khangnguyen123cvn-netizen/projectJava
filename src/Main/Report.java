package Main;

import java.util.ArrayList;
import java.util.List;
public class Report 
{
        private List<Transaction> transactionList;
        
        public Report()
        {
             this.transactionList = new ArrayList<>();
        }
       
        public void addTransaction(Transaction t) 
        {
            this.transactionList.add(t);
        }
        public void report()
       {
            System.out.printf("| %-6s | %-12s | %-8s | %-20s |\n", "ID", "Tên", "Số lượng", "Thời gian");
            for (Transaction t : transactionList)
        {
            System.out.printf("| %-6s | %-12s | %-8d | %-20s |\n",  t.getProductId(), t.getName(), t.getQuantity(), t.getTimestamp());
        }
       }
        
}
