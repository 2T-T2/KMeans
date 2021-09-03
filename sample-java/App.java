import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // Irisデータセットより一部抜粋
        Float[][] data = {
            // setosa
            {5.1f, 3.5f, 1.4f, 0.2f},
            {4.9f, 3.0f, 1.4f, 0.2f},
            {4.7f, 3.2f, 1.3f, 0.2f},
            {4.6f, 3.1f, 1.5f, 0.2f},
            {5.0f, 3.6f, 1.4f, 0.2f},
            // versicolor
            {7.0f, 3.2f, 4.7f, 1.4f},	
            {6.4f, 3.2f, 4.5f, 1.5f},
            {6.9f, 3.1f, 4.9f, 1.5f},
            {5.5f, 2.3f, 4f, 1.3f},
            {6.5f, 2.8f, 4.6f, 1.5f},
            // virginica
            {4.9f, 2.5f, 4.5f, 1.7f},
            {7.3f, 2.9f, 6.3f, 1.8f},
            {6.7f, 2.5f, 5.8f, 1.8f},
            {7.2f, 3.6f, 6.1f, 2.5f},
            {6.5f, 3.2f, 5.1f, 2f},
        };
        K_Means km = new K_Means(data);
        System.out.println( Arrays.toString(km.fit(3)) );
    }
}
