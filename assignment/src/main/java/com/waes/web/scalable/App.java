package com.waes.web.scalable;

import com.waes.web.scalable.persistence.LeftRightData;
import com.waes.web.scalable.service.DiffService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main for debugging
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext aplicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        DiffService diffService = (DiffService) aplicationContext.getBean("diffService");

        LeftRightData data = new LeftRightData();
        data.setId(1);
        data.setLeft("This is left!");
        data.setRight("This is right!");
        diffService.update(data);

        LeftRightData data2 = new LeftRightData();
        data2.setId(2);
        data2.setLeft("This is sparta!");
        data2.setRight("This is true sparta!");
        diffService.update(data2);

        LeftRightData data3 = new LeftRightData();
        data3.setId(3);
        data3.setLeft("This is not right!");
        data3.setRight("This is not left!");
        diffService.update(data3);
        System.out.println("Data inserted!");

        LeftRightData search = diffService.findById(2);
        System.out.println("Data left: " + search.getLeft());
        System.out.println("Data right: " + search.getRight());

    }
}
