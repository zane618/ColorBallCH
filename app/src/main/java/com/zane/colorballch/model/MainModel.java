package com.zane.colorballch.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shizhang on 2017/10/29.
 */

public class MainModel {
    public static boolean flag;
    private List<ColorBallBean> redBalls;
    private List<String> redNol = new ArrayList<>();
    private List<String> redY = new ArrayList<>();

    private List<ColorBallBean> blueBalls;
    private List<String> blueNol = new ArrayList<>();
    private List<String> blueY = new ArrayList<>();

    public MainModel() {
        redBalls = new ArrayList<>();
        blueBalls = new ArrayList<>();
        for(int i=0;i< 33;i++) {
            redBalls.add(new ColorBallBean(0, i + 1));
            redNol.add(i + 1 + "");
        }
        for(int i=0;i< 16;i++) {
            blueNol.add(i + 1 + "");
            blueBalls.add(new ColorBallBean(0, i + 1));
        }
    }

    public void updateRedBalls(int position) {
        switch (redBalls.get(position).status) {
            case 0:
                redBalls.get(position).status += 1;
                redNol.remove(String.valueOf(redBalls.get(position).text));
                break;
            case 1:
                redBalls.get(position).status += 1;
                redY.add(redBalls.get(position).text + "");
//                redNol.remove(String.valueOf(redBalls.get(position).text));
                break;
            case 2:
                redBalls.get(position).status = 0;
                redNol.add(redBalls.get(position).text + "");
                redY.remove(redBalls.get(position).text + "");
                break;
        }
    }

    public void updateBlueBalls(int position) {
        switch (blueBalls.get(position).status) {
            case 0:
                blueBalls.get(position).status += 1;
                blueNol.remove(String.valueOf(blueBalls.get(position).text));
                break;
            case 1:
                blueBalls.get(position).status += 1;
                blueY.add(blueBalls.get(position).text + "");
//                blueNol.remove(String.valueOf(blueBalls.get(position).text));
                break;
            case 2:
                blueBalls.get(position).status = 0;
                blueNol.add(blueBalls.get(position).text + "");
                blueY.remove(blueBalls.get(position).text + "");
                break;
        }
    }
    public List<ColorBallBean> getRedBalls() {
        return redBalls;
    }

    public List<ColorBallBean> getBlueBalls() {
        return blueBalls;
    }

    public String random() {
        List<String> tmpRedY = new ArrayList<>();
        tmpRedY.addAll(redY);
        List<String> tmpRedNol = new ArrayList<>();
        tmpRedNol.addAll(redNol);

        List<String> ran = new ArrayList<>();
        Random r = new Random();
        if (redY.size() > 6) {
            while (ran.size() < 6) {
                String rValue = tmpRedY.get(r.nextInt(tmpRedY.size()));
                ran.add(rValue);
                tmpRedY.remove(rValue);
            }
            //红色 >= 6的时候，再添加个蓝色
            randomBlue(ran);
            StringBuilder result = new StringBuilder("红球   ");
            for (int x = 0; x < ran.size(); x++) {
                if (x == 6) {
                    result.append("    篮球  ");
                }
                result.append(ran.get(x) + " ");
            }
            return result.toString();
        } else {
            while (tmpRedY.size() > 0) {
                String rValue = tmpRedY.get(r.nextInt(tmpRedY.size()));
                ran.add(rValue);
                tmpRedY.remove(rValue);
            }
            while (ran.size() < 6) {
                String rValue = tmpRedNol.get(r.nextInt(tmpRedNol.size()));
                ran.add(rValue);
                tmpRedNol.remove(rValue);
            }
            randomBlue(ran);
            StringBuilder result = new StringBuilder("红球   ");
            for (int x = 0; x < ran.size(); x++) {
                if (x == 6) {
                    result.append("篮球  ");
                }
                result.append(ran.get(x) + " ");
            }
            return result.toString();
        }
    }

    private void randomBlue(List<String> redList) {
        sortList(redList, ">");
        if (blueY.size() > 1) {
            redList.add(blueY.get(new Random().nextInt(blueY.size())));
        } else if (blueY.size() == 1) {
            redList.add(blueY.get(0));
        } else {
            redList.add(blueNol.get(new Random().nextInt(blueNol.size())));
        }
    }
    /**
     * @param list
     * @param operation 操作符：>表示升序，<表示降序
     */
    public static void sortList(List list ,String operation) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-i-1; j++) {
                int a = Integer.parseInt(list.get(j).toString());
                int b = Integer.parseInt(list.get(j+1).toString());
                if(">".equals(operation)){
                    if(a>b){
                        list.set(j, b + "");
                        list.set(j+1, a + "");
                    }
                }else{
                    if(a<b){
                        list.set(j, b + "");
                        list.set(j+1, a + "");
                    }
                }
            }
        }
    }
}
