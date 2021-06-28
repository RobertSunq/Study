import com.alibaba.druid.util.StringUtils;
import com.alibaba.druid.wall.Violation;
import com.qing.corejavolume.core.demo.domain.DemoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * test
 * <p>
 * Author: sunQB
 * Date: 2021-06-02 14:47
 * Since: JDK-1.8
 */

@Slf4j
public class test {

    @Test
    public void testSomething() {
//        System.out.println(1L << 10);
////        long i = 0x3ff;
////        System.out.println(i);
//        System.out.println(0b10000000000);

        Set<String> set1 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("地下城与勇士");
                add("魔兽世界");
                add("魔兽世界1");
                add("魔兽世界2");
            }
        };

        Set<String> set2 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("地下城与勇士");
                add("魔兽世界");
            }
        };
        Set<String> set = new HashSet<String>(set1);
        set.retainAll(set2);
        System.out.println(set);
        set1.removeAll(set2);
        System.out.println(set1);
        int[] v = new int[]{1, 2, 4, 5, 6, 7};
        /*int[]转list*/
        // java8及以上版本
        List<Integer> list1 = Arrays.stream(v).boxed().collect(Collectors.toList());
        System.out.println(list1);
        /*list转int[]*/
        //方法一：
        Integer[] intArr = list1.toArray(new Integer[list1.size()]);
        //方法二：java8及以上版本
        int[] intArr1 = list1.stream().mapToInt(Integer::valueOf).toArray();


    }

    @Test
    public void testSomething01() {
        DemoEntity newObj = new DemoEntity();
        DemoEntity oldObj = new DemoEntity();
        // 不需要比较的字段
        String filterString = "serialVersionUID,id";
        Set<String> filterSet = new HashSet<>(Arrays.asList(filterString.split(",")));
        try {
            Field[] fields = getAllFields(newObj, filterSet);
            for (Field field : fields) {
                // 不调用 访问安全检查
                field.setAccessible(true);
                // 如果字段分类型对比
                if (field.getType() == String.class) {
                    if (!StringUtils.equals((String) field.get(newObj), (String) field.get(oldObj))) {
                        System.out.println("已修改");
                    }
                }
                if (field.getType() == BigDecimal.class) {
                    if (!compareBigDecimal((BigDecimal) field.get(newObj), (BigDecimal) field.get(oldObj))) {
                        System.out.println("已修改");
                    }
                }
                if (field.getType() == Date.class) {
                    if (!compareDate((Date) field.get(newObj), (Date) field.get(oldObj))) {
                        System.out.println("已修改");
                    }
                }
            }
        } catch (IllegalAccessException e) {
            log.error(e.toString());
        }

        System.out.println("未修改");
    }

    /**
     * 获取所有属性，包括父类
     */
    public Field[] getAllFields(Object object) {
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }


    /**
     * 获取指定对象的所有属性，包括父类，并根据过滤条件删除指定属性
     *
     * @param object 对象实体
     * @param filter 过滤条件
     * @return Field[]
     */
    public Field[] getAllFields(Object object, Set<String> filter) {
        // 获取当前对象实体
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        // 遍历获取本身以及所有父类的属性
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        // 根据filter过滤条件删除不需要的属性
        List<Field> fieldListFilter = fieldList.stream().filter(e -> !filter.contains(e.getName())).collect(Collectors.toList());
        Field[] fields = new Field[fieldListFilter.size()];
        fieldListFilter.toArray(fields);
        return fields;
    }


    /**
     * 对比两个 BigDecimal 是否相等
     *
     * @param newBigDecimal 1
     * @param oldBigDecimal 2
     * @return boolean
     */
    public static boolean compareBigDecimal(BigDecimal newBigDecimal, BigDecimal oldBigDecimal) {
        if (newBigDecimal == null && oldBigDecimal == null) {
            return true;
        } else if (newBigDecimal == null || oldBigDecimal == null) {
            return false;
        }
        return newBigDecimal.compareTo(oldBigDecimal) == 0;
    }


    /**
     * 对比两个 Date 是否相等
     *
     * @param newDate 1
     * @param oldDate 2
     * @return boolean
     */
    public static boolean compareDate(Date newDate, Date oldDate) {

        if (newDate == null && oldDate == null) {
            return true;
        } else if (newDate == null || oldDate == null) {
            return false;
        }
        return newDate.compareTo(oldDate) == 0;
    }


    @Test
    public void test2() {

        String str = "12312312  231242 3234 ";
        String s = str.replaceAll(" ", "");
        int[][] a = new int[][]{{9, 8, 7, 2, 3, 4, 1, 0, 6, 5},{9, 9, 7, 2, 3, 4, 1, 0, 6, 5}};
        Arrays.sort(a,(a1,a2) ->{
            return a2[1] - a1[1];
        });
        for (int[] value : a) {
            System.out.print(value[1] + " ");
        }
        System.out.println();
        int[] aa = new int[]{9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        Arrays.sort( aa );
        for (int value : aa) {
            System.out.print(value + " ");
        }
        int b = 23234233;
        System.out.println((b & 1));


        label86: {

            int t1 = 1;
            int t2 = new Random().nextInt();
            if (t1 != t2) {
                break label86;
            }
            if (t1 != t2) {
                System.out.println(1333111);
            }

            System.out.println(1111);
        }
        System.out.println(2222);
    }

}
