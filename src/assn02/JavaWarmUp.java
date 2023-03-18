package assn02;
import java.util.Scanner;
import java.util.LinkedList;

public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("How many items will be entered: ");
        int count = s.nextInt();
        Electronic[] eList = new Electronic[count];
        for(int i = 0; i < count; i++) {
            Electronic item = new Electronic();
            eList[i] = item;
            item._date = s.next();
            item._time = s.next();
            item._category = s.next();
            item._fee = s.nextFloat();
            item._quantity = s.nextInt();
            item._totalTime = s.nextFloat();
            item._cost = s.nextInt();
        }
        int maxIndex = getMaxPriceIndex(count, eList);
        int minIndex = getMinPriceIndex(count, eList);
        System.out.println("Highest per unit assembling fee:\n\tWhen: " + eList[maxIndex]._date + " " + eList[maxIndex]._time + "\n\tCategory: " + eList[maxIndex]._category + "\n\tPrice: " + eList[maxIndex]._fee);
        System.out.println("Lowest per unit assembling fee:\n\tWhen: " + eList[minIndex]._date + " " + eList[minIndex]._time + "\n\tCategory: " + eList[minIndex]._category + "\n\tPrice: " + eList[minIndex]._fee);
        getStatOf(count, eList, "phone");
        getStatOf(count, eList, "laptop");
        getStatOf(count, eList, "smart_watch");
    }
    public static int getMaxPriceIndex(int count, Electronic[] eList) {
        int index = 0;
        for (int i = 0; i < count; i++) {
            if(eList[i]._fee > eList[index]._fee)
                index = i;
        }
        return index;
    }

    public static int getMinPriceIndex(int count, Electronic[] eList) {
        int index = 0;
        for (int i = 0; i < count; i++) {
            if(eList[i]._fee < eList[index]._fee)
                index = i;
        }
        return index;
    }

    public static void getStatOf(int count, Electronic[] eList, String category) {
        int quantity = 0;
        float fee = 0;
        float time = 0;
        float cost = 0;
        for (int i = 0; i < count; i++) {
            if(eList[i]._category.equals(category)) {
                quantity += eList[i]._quantity;
                fee += eList[i]._fee * eList[i]._quantity;
                cost += eList[i]._cost;
                time += eList[i]._totalTime;
            }
        }
        System.out.println("Statistic of " + category);
        System.out.println("\tQuantity: " + quantity);
        System.out.println("\tAverage Assembling fee: " + String.format("%.2f", fee / quantity));
        System.out.println("\tAverage Net Profit: " + String.format("%.2f", (fee - (cost + (time * 16))) / quantity));
    }

}
