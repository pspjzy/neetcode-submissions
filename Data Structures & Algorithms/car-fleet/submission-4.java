
class Solution {

    class Car {
        int position;
        double time;

        Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        // 创建每辆车
        for (int i = 0; i < position.length; i++) {
            double time =
                    (double) (target - position[i]) / speed[i];

            cars.add(new Car(position[i], time));
        }

        // 按位置从大到小排序
        // 离终点最近的车放前面
        cars.sort((a, b) ->
                Integer.compare(b.position, a.position)
        );

        int fleets = 0;
        double previousTime = 0;

        for (Car car : cars) {

            // 如果当前车需要更长时间到达终点，
            // 说明它追不上前面的 fleet
            if (car.time > previousTime) {
                fleets++;
                previousTime = car.time;
            }

            // car.time <= previousTime
            // 说明能追上前面的 fleet
            // 什么都不用做
        }

        return fleets;
    }
}