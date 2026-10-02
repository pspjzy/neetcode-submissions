class TimeMap {
    class T {
        String value;
        int timestamp;
        T(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<T>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new T(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<T> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 保存当前答案;
            // 去右边看看有没有更大的合法 timestamp;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
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