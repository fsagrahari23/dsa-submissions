class MedianFinder {

    PriorityQueue<Double> pq;

    public MedianFinder() {
        pq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        pq.add((double) num);
    }

    public double findMedian() {

        PriorityQueue<Double> np = new PriorityQueue<>(pq);

        int size = np.size();

        if (size % 2 == 0) {

            for (int i = 0; i < size / 2 - 1; i++) {
                np.poll();
            }

            double a = np.poll();
            double b = np.poll();

            return (a + b) / 2.0;

        } else {

            for (int i = 0; i < size / 2; i++) {
                np.poll();
            }

            return np.poll();
        }
    }
}