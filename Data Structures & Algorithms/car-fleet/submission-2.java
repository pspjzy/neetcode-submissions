class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // cars[i][0] = position
        // cars[i][1] = time to reach target
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // 按 position 从大到小排序
        // 离 target 最近的车先处理
        Arrays.sort(cars, (a, b) ->
                Double.compare(b[0], a[0])
        );

        Stack<Double> stack = new Stack<>();

        for (double[] car : cars) {

            double time = car[1];

            /*
             * stack 顶部代表前面那个 fleet 到终点需要的时间
             *
             * 如果当前车 time > stack.peek()
             *
             * 说明当前车更慢，追不上前面的 fleet
             * → 形成新的 fleet
             */
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }

            /*
             * 如果：
             *
             * time <= stack.peek()
             *
             * 当前车理论上更早或同时到终点，
             * 说明它一定会追上前面的 fleet。
             *
             * 所以什么都不用做：
             * 它直接并入前面的 fleet。
             */
        }

        return stack.size();
    }
}