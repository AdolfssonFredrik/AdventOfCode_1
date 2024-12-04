import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Input {

    private final ArrayList<Integer> leftList;
    private final ArrayList<Integer> rightList;
    public Input() throws IOException {
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
    }


    public void parseFile(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));

        String line;

        StringTokenizer st;

        int counter = 0;

        while((line = br.readLine()) != null){
            st = new StringTokenizer(line, " ");

            leftList.add(Integer.parseInt(st.nextToken()));
            rightList.add(Integer.parseInt(st.nextToken()));
            counter++;
        }
        br.close();
        System.out.println(counter);
    }

    public ArrayList<Integer> getLeftList() {
        return leftList;
    }
    public ArrayList<Integer> getRightList() {
        return rightList;
    }
}
