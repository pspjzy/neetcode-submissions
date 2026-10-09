class Solution {
    
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<position.length; i++){
            double time = (double)(target - position[i])/(double)speed[i];
            cars.add(new Car(position[i], time));
        }
        cars.sort((a,b) -> Integer.compare(b.position, a.position));
        int fleets = 0;
        double previousTime = 0;

        // Deque<Double> stack = new ArrayDeque<>();

        // for (Car c : cars) {
        //     if (stack.isEmpty() || c.time > stack.peek()) {
        //         stack.push(c.time);
        //     }
        // }
        for(Car c: cars){
            if(c.time > previousTime){
                fleets++;
                previousTime = c.time;
            }
        }
        return fleets;
        
    }
}

class Car {
        int position;
        double time;

        Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
}
