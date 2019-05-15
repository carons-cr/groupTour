package util;

import model.TravelNote;

import java.util.*;

public class KMeans {
    public double[][] DATA;
    public int k;
    public int[] nearestCenterIndexOfDatas;//每个数据最近的中心点序号0~k-1
    public double[][] centers;
    public int[] nearDataCountOfCenters;//每个中心点附近的数据数量

    public int[] getMembersIndex(int dataIndex) {
        String lastNearestCenterIndexOfDatas = "";
        String nowNearestCenterIndexOfDatas = "";
        randomCenters();
        for (int i = 0; i < 500; i++) {
            calNearestCenterIndexOfDatas();
            nowNearestCenterIndexOfDatas = Arrays.toString(nearestCenterIndexOfDatas);
            if (nowNearestCenterIndexOfDatas.equals(lastNearestCenterIndexOfDatas)) {
                break;
            }else {
                lastNearestCenterIndexOfDatas = nowNearestCenterIndexOfDatas;
            }
            calNewCenters();
        }
        int len = nearDataCountOfCenters[nearestCenterIndexOfDatas[dataIndex]] - 1;
        int[] membersIndex = new int[len];
        int j = 0;
        for (int i = 0; i < DATA.length; i++) {
            if (nearestCenterIndexOfDatas[i] == nearestCenterIndexOfDatas[dataIndex] && i != dataIndex) {
                membersIndex[j++] = i;
            }
        }
        return  membersIndex;
    }

    public KMeans(int k) {
        this.k = k;
    }

    public void randomCenters() {
        centers = new double[k][DATA[0].length];
        Random random = new Random();
        Map map = new HashMap();
        for (int i =0; i < k; i++) {
            int index = Math.abs(random.nextInt())%DATA.length;
            if (map.containsKey(index))
                i--;
            else {
                map.put(index, DATA[index]);
                for (int j = 0; j < DATA[0].length; j++) {
                    centers[i][j] = DATA[index][j];
                }
            }
        }
    }

    public void calNearestCenterIndexOfDatas() {
        nearestCenterIndexOfDatas= new int[DATA.length];
        nearDataCountOfCenters = new int[k];
        for (int i = 0; i < DATA.length; i++) {
            double currentDistance = Double.MAX_VALUE;
            int currentIndex = -1;
            double[] currentData = DATA[i];
            for (int j = 0; j < k; j++) {
                double distance = getManhattanDistance(currentData, centers[j]);
                if (distance < currentDistance) {
                    currentDistance = distance;
                    currentIndex = j;
                }
            }
            nearestCenterIndexOfDatas[i] = currentIndex;
        }
        for (int i = 0; i < nearestCenterIndexOfDatas.length; i++) {
            nearDataCountOfCenters[nearestCenterIndexOfDatas[i]]++;
        }
    }

    public void calNewCenters() {
        centers = new double[k][DATA[0].length];
        for (int i = 0; i < nearestCenterIndexOfDatas.length; i++) {
            for (int j = 0; j < DATA[0].length; j++) {
                centers[nearestCenterIndexOfDatas[i]][j] += DATA[i][j];
            }
        }
        for (int i = 0; i < centers.length; i++) {
            for (int j = 0; j < DATA[0].length; j++) {
                centers[i][j] /= nearDataCountOfCenters[i];
            }
        }
    }

    public double getManhattanDistance(double[] firstData, double[] secondData) {
        double distance = 0;
        if (firstData != null && secondData != null && firstData.length == secondData.length) {
            for (int i = 0; i < firstData.length; i++) {
                distance += Math.abs(firstData[i] - secondData[i]);
            }
        }else {
            System.out.println("firstData 与 secondData 数据结构不一致");
        }
        return distance;
    }

    public double[] getData(Integer age, String sex, int[] travelNotesId) {
        double[] data = new double[5];
        if (age != null) {
            data[0] = 1.0*age / 100;
        }else {
            data[0] = 0.0/100;
        }
        if (sex != null) {
            if (sex.equals("男")) {
                data[1] = 0.0 / 10;
            } else {
                data[1] = 1.0 / 10;
            }
        }else {
            data[1] = 0.0/10;
        }
        if (travelNotesId != null) {
            for (int i = 0; i < travelNotesId.length; i++) {
                data[i+2] = 1.0*travelNotesId[i] / 10;
            }
        }else {
            for (int i = 0; i < 3; i++) {
                data[i+2] = 0.0 / 10;
            }
        }
        return data;
    }
}
