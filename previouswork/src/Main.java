import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

/**
 * Created by manish on 1/21/17.
 */
public class Main {

    public static void main(String args[]){
        Point pnt1 = new Point(0,0);
        Point pnt2 = new Point(0,0);
        System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
        System.out.println(" ");
        tricky(pnt1,pnt2);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
    }

    public static void tricky(Point arg1, Point arg2)
    {
        arg1.x = 100;
        arg1.y = 100;
        Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }


    public static HashMap<Integer, List<Integer>> readFile() throws Exception {
        File file = new File("ratings.txt");
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line != null) {
                    String[] values=line.split(" ");
                    int key = Integer.parseInt(values[0]);
                    int value = Integer.parseInt(values[1]);
                    if(map.containsKey(key)) {
                       map.get(key).add(value);
                    }
                    else {
                        final List<Integer> list = new ArrayList<>();
                        list.add(value);
                        map.put(key, list);
                    }
                }
            }
            return map;
        }
        catch(Exception e) {
            throw e;
        }
    }


    public static void printMean() throws Exception{
        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) {
                    return 1;
                } else if(o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        HashMap<Integer, List<Integer>> map = readFile();
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            entry.getValue().sort(compare);
            float mean = getMean(entry.getValue(), 5);
            System.out.println(entry.getKey() +"=" + mean);
        }
    }

    private static float getMean(List<Integer> list, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + list.get(i);
        }
        return sum / k;
    }
}




