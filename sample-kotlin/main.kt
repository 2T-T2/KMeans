fun main() {
    // Irisデータセットより一部抜粋
    val array = arrayOf(
        // setosa
        arrayOf(5.1f,3.5f,1.4f,0.2f),
        arrayOf(4.9f,3.0f,1.4f,0.2f),
        arrayOf(4.7f,3.2f,1.3f,0.2f),
        arrayOf(4.6f,3.1f,1.5f,0.2f),
        arrayOf(5.0f, 3.6f,1.4f ,0.2f),
        // versicolor
        arrayOf(7.0f, 3.2f, 4.7f, 1.4f),	
        arrayOf(6.4f, 3.2f, 4.5f, 1.5f),
        arrayOf(6.9f, 3.1f, 4.9f, 1.5f),
        arrayOf(5.5f, 2.3f, 4f, 1.3f),
        arrayOf(6.5f, 2.8f, 4.6f, 1.5f),
        // virginica
        arrayOf(4.9f, 2.5f, 4.5f, 1.7f),
        arrayOf(7.3f, 2.9f, 6.3f, 1.8f),
        arrayOf(6.7f, 2.5f, 5.8f, 1.8f),
        arrayOf(7.2f, 3.6f, 6.1f, 2.5f),
        arrayOf(6.5f, 3.2f, 5.1f, 2f),
    );

    val km = K_Means(array);
    km.fit(3).forEach {
        print(it+" ")
    }
}
