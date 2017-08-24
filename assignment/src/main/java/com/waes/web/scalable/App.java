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
        data.setId(2);
        data.setLeft("This is not right!");
        data.setRight("This is not left!");
        diffService.update(data);
        System.out.println("Data inserted!");

        LeftRightData search = diffService.findById(2);
        System.out.println("Data left: " + search.getLeft());
        System.out.println("Data right: " + search.getRight());

    }
}
