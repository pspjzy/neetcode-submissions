class TimeMap {
    class T {
        String value;
        int timestamp;

        T(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    // key -> 这个 key 的所有历史 value
    Map<String, List<T>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        // 如果这个 key 第一次出现，就创建新的 List
        map.putIfAbsent(key, new ArrayList<>());

        // timestamp 按题目保证是递增的
        // 所以直接加到最后即可
        map.get(key).add(new T(value, timestamp));
    }

    public String get(String key, int timestamp) {

        // key 从来不存在
        if (!map.containsKey(key)) {
            return "";
        }

        List<T> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // 当前 timestamp 可以使用
            if (list.get(mid).timestamp <= timestamp) {

                result = list.get(mid).value;

                // 但是我们还想找更大的 timestamp
                // 所以继续向右
                left = mid + 1;

            } else {

                // timestamp 太大了
                // 往左找
                right = mid - 1;
            }
        }

        return result;
    }
}