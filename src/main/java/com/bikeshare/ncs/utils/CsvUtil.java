package com.bikeshare.ncs.utils;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.extend.NcsDayUsageExtend;
import com.bikeshare.ncs.bean.extend.NcsHourUsageExtend;
import io.swagger.models.auth.In;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 /**
  * @name CsvUtil
  * @date 2020/4/30
  * @author ncs
  * @description 转换csv文件为List
 **/
public class CsvUtil {
    public static List<NcsDayUsageExtend>  ConvertDayCsvToList() {
        List<NcsDayUsageExtend> dayUsageExtends = new ArrayList<NcsDayUsageExtend>();//保存读取csv得到的数据
        Map<String, List<NcsDayUsageExtend>> map = new HashMap<String, List<NcsDayUsageExtend>>();//分组统计的map集合
        String sbip = null;
        List<NcsHourUsageExtend> test = new ArrayList<NcsHourUsageExtend>();//map集合中每组ip的对应的对象集合
        BufferedReader reader = null;
        //读写csv数据到list(dkinfos)集合中
        try {
            reader = new BufferedReader(new FileReader("D:/day.csv"));//换成你的文件名
            String line = null;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                NcsDayUsageExtend dayUsageExtend = new NcsDayUsageExtend();
                NcsDay day=new NcsDay();
                day.setYear(data[1].split("-")[0]);
                day.setMonth(data[1].split("-")[1]);
                day.setDay(data[1].split("-")[2]);
                day.setWeek(data[6]);
                day.setHoliday(data[5]);
                day.setSeason(Integer.parseInt(data[2]));
                day.setWeather(data[8]);
                dayUsageExtend.setDays(day);
                dayUsageExtend.setTemperature(Double.parseDouble(data[9]));
                dayUsageExtend.setUnregisterUsage(Long.parseLong(data[13]));
                dayUsageExtend.setRegisterUsage(Long.parseLong(data[14]));
                dayUsageExtend.setTotalUsage(Long.parseLong(data[15]));
                dayUsageExtends.add(dayUsageExtend);
            }
            //遍历集合，将数据分组存入map集合
//            for (NcsDayUsageExtend dkinfo : dkinfos) {
//                sbip = dkinfo.getSbip();
//                mapDkinfos = map.get(sbip);//获取对应sbip的集合，第一次获取时为空
//                if (mapDkinfos == null) {//这里如果不进行为空判断，会报空指针异常
//                    mapDkinfos = new ArrayList<NcsDayUsageExtend>();
//                }
//                mapDkinfos.add(dkinfo);//将新添加的对象加入到对应的sbip的对象集合
//                map.put(sbip, mapDkinfos); //将每次新添加对象后的对象集合存入对应map中
//            }
//            //遍历map集合
//            for (Map.Entry<String, List<NcsDayUsageExtend>> entry : map.entrySet()) {
//                System.out.println("设备ip = " + entry.getKey() + ", 端口数 = " + entry.getValue().size());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                //dkinfos.clear();
                map.clear();
                //mapDkinfos.clear();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return dayUsageExtends;
    }
    public static List<NcsHourUsageExtend>  ConvertHourCsvToList() {
        List<NcsHourUsageExtend> hourUsageExtends = new ArrayList<NcsHourUsageExtend>();//保存读取csv得到的数据
        List<Integer> test = new ArrayList<Integer>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("D:/hour.csv"));//换成你的文件名
            String line = null;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                NcsHourUsageExtend hourUsageExtend = new NcsHourUsageExtend();
                NcsDay day = new NcsDay();
                day.setYear(data[1].split("-")[0]);
                day.setMonth(data[1].split("-")[1]);
                day.setDay(data[1].split("-")[2]);
                day.setWeek(data[7]);
                day.setHoliday(data[6]);
                day.setSeason(Integer.parseInt(data[2]));
                day.setWeek(data[9]);
                hourUsageExtend.setDays(day);
                hourUsageExtend.setHour(Integer.parseInt(data[5]));
                hourUsageExtend.setTemperature(Double.parseDouble(data[10]));
                hourUsageExtend.setUnregisterUsage(Long.parseLong(data[14]));
                hourUsageExtend.setRegisterUsage(Long.parseLong(data[15]));
                hourUsageExtend.setTotalUsage(Long.parseLong(data[16]));
                hourUsageExtends.add(hourUsageExtend);
                if(hourUsageExtend.getHour().equals(23)){
                    test.add(Integer.parseInt(data[0]));
                }
            }
            int old=0;
            Iterator<Integer> iterator=test.iterator();
            while (iterator.hasNext()){
                int newV=iterator.next();
                if(newV-old>24){
                    System.out.println(newV);
                }
                old=newV;
            }
            System.out.println(test);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return hourUsageExtends;
    }
}
