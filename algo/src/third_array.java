public class third_array {

    public static void main(String[] args) {
        int[][][] arr = {
                {
                    {1, 2, 3}, 
                    {4, 5, 6},
                },
                {
                    {7, 8, 9},
                    {10, 11, 12},
                },
                {
                    {13, 14, 15}, 
                    {16, 17, 18},
                },
                {
                    {19, 20, 21},
                    {21, 22, 23},
                }
        };

        System.out.println("arr.length = " + arr.length);


        int[][][] arr2 = new int[4][2][3];
        arr2[3][1][2] = 999;
        System.out.println("arr2[3][1][2] = " + arr2[3][1][2]);
    }
}
