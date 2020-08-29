package com.chensong.demo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: Type
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/26 22:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/26 22:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StreamDemo {

   static List<Dish> menue = Arrays.asList(
        new Dish("pork",false,800,Type.META),
            new Dish("beef",false,700,Type.META),
         new Dish("chicken",false,400,Type.META),
         new Dish("frnch fries",true,300,Type.OTHER),
         new Dish("rice",true,800,Type.OTHER),
         new Dish("pork",true,800,Type.OTHER),
         new Dish("season fruit",false,800,Type.META),
            new Dish("pizza",true,800,Type.META),
            new Dish("prawns",false,800,Type.FISH),
             new Dish("salmon",false,800,Type.FISH)

    );



    public static void  main(String [] args){
        Map<Type, List<Dish>> map = menue.stream().collect(Collectors.groupingBy(Dish::getType)); //根据类型分组
        System.out.println(map);
//=======================================================
        List<String> list1 = menue.stream().map(Dish::getName).distinct().collect(Collectors.toList());  //去重

        System.out.println(list1);
//===================================================================================
        List<Dish> collet=menue.stream().filter(u->"pork".equals(u.getName())).collect(Collectors.toList()); //过滤
        System.out.println(collet);

//======================================================================================



        //求和 Integer 类型
        Optional<Integer> reduce = menue.stream().map(Dish::getCalories).reduce(Integer::sum);
        System.err.println("reduce.get():"+reduce.get());

        // 取字段string转int构建新列表 再求和
        List<Integer> collect = menue.stream().map(dto -> Integer.valueOf(dto.getCalories())).collect(Collectors.toList());
        Optional<Integer> reduce1 = collect.stream().reduce(Integer::sum);
        System.err.println("reduce1.get():"+reduce1.get());
//====================================================================================================================
       //，Double或者int的求和最大，最小，平均值
        /**
         * list.stream().mapToDouble(User::getHeight).sum()//和
         * list.stream().mapToDouble(User::getHeight).max()//最大
         * list.stream().mapToDouble(User::getHeight).min()//最小
         * list.stream().mapToDouble(User::getHeight).average()//平均值
         */
        double sum = menue.stream().mapToDouble(Dish::getCalories).sum();//和  mapToint()
        System.out.println("mapToDoublesum:"+sum);
        double average = menue.stream().mapToDouble(Dish::getCalories).average().getAsDouble();
        System.out.println("average:"+average);

        //一般使用  double sum = list.stream().mapToDouble(User::getHeight).sum();
        //        System.out.println("身高 总和：" + df.format(sum));
        //        double max = list.stream().mapToDouble(User::getHeight).max().getAsDouble();
        //        System.out.println("身高 最大：" + df.format(max));
        //        double min = list.stream().mapToDouble(User::getHeight).min().getAsDouble();
        //        System.out.println("身高 最小：" + df.format(min));
        //        double average = list.stream().mapToDouble(User::getHeight).average().getAsDouble();
        //        System.out.println("身高 平均：" + df.format(average));
//========================================================================================================================
         final DecimalFormat df = new DecimalFormat("0.00");//保留两位小数点
        Random random = new Random();
        List<User> list4 = new ArrayList<>();
        for(int i=1;i<=5;i++) {
            double weight = random.nextDouble() * 100 + 100;//随机身高：100-200
            list4.add(new User(i, new BigDecimal(weight).setScale(BigDecimal.ROUND_HALF_UP, 2)));
        }
        System.out.println("list：" + list4);
        BigDecimal add = list4.stream().map(User::getHeight).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("身高 总和：" + df.format(add));
        Optional<User> max = list4.stream().max((u1, u2) -> u1.getHeight().compareTo(u2.getHeight()));
        System.out.println("身高 最大：" + df.format(max.get().getHeight()));
        Optional<User> min = list4.stream().min((u1, u2) -> u1.getHeight().compareTo(u2.getHeight()));
        System.out.println("身高 最小：" + df.format(min.get().getHeight()));


//========================================================================================================================

        List<Integer> list =new ArrayList<Integer>();
        for (int i=0;i<1000;i++){
            list.add(i);
        }
        //中间操作
        //filter() 过滤
        //sorted 排序
        // map 映射
        //distinct 去重

        //终止操作 点不出来了
        list.stream().filter(i ->i>500).sorted((o1,o2)->o2.compareTo(o1)).limit(10)
                .forEach(j ->   //j为int型
                         System.out.println(j)
                ); //大于500才输出




        // //list转化为Map

//            Map<String,Dish>  dishMap = menue.stream().collect(Collectors.toMap(Dish::getName,a ->a ));
//            System.err.println("dishMap:==========="+dishMap);  //这个会报错Duplicate
        //如果集合对象有重复的key会报Duplicate 错误
        //我们可以用 (k1,k2) ->k1来设置 如果有重复的key，则保留key1 舍弃 key2
        Map<String,Dish>  dishMap1 = menue.stream().collect(Collectors.toMap(Dish::getName,a ->a ,(k1,k2)->k2));
        System.err.println("dishMap1:==========="+dishMap1);  //这个会报错Duplicate

        //1.遍历上面的Map(通过Map.keySet遍历key和value)
        dishMap1.keySet().forEach(key -> System.out.println("key:" +key+",value:"+dishMap1.get(key)));

        //2通过Map.entrySet使用Iterator遍历key和value
        dishMap1.entrySet().iterator().forEachRemaining(
                item-> System.out.println("key:value is:"+item.getKey()+":"+ item.getValue())
        );

        //3通过Map.entrySet遍历key和value，在大容量时推荐使用
        dishMap1.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));


        //4通过Map.values()遍历所有的value，但不能遍历key
        dishMap1.values().forEach(System.out::println); // 等价于map.values().forEach(value -> System.out.println(value));

        //5通过k,v遍历，Java8独有的
        dishMap1.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));


        //使用java 8 遍历上面的List
        menue.forEach(item -> System.out.println("遍历list:"+item));
        menue.forEach(System.out::println);
        //遍历加判断
        menue.forEach(item->{
            if("pork".equals(item.getName())){
                System.out.println("判断条件："+item);
            }
        });


        //Java8 Stream.forEach输出List<Map<String, Object>>数据
        List<Map<String,Object>> list3 =new ArrayList();
        Map<String,Object> map2 =new HashMap<>();
        map2.put("1", new Dish("pork",false,800,Type.META) );
        list3.add(map2);
        map2.put("2",new Dish("salmon",false,800,Type.FISH));
        list3.add(map2);
        map2.put("3",new Dish("prawns",false,800,Type.FISH));
        list3.add(map2);
        map2.put("4",new Dish("season fruit",false,800,Type.META));
        list3.add(map2);


        //输出List集合中Map数据
        list3.stream()
                .forEach(mp->
                        mp.forEach((key,val)->
                                System.out.println("name: "+key+" "+"value:"+val)));

        list3.stream().forEach(mm->{
            if(!mm.isEmpty()){
                mm.forEach((k2,v2)->{
                    System.out.println("key:value = " + k2 + ":" + v2) ;
                });
            }
        });



    }




}
