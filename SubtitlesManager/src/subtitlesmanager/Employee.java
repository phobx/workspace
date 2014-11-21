/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subtitlesmanager;

import java.util.Date;

/**
 *
 * @author yaroslav.hulaga
 */
public class Employee {

    public Employee() {
        this.ID = currentID;
        currentID++;
    }
    private String Name;
    private Date HireDay;
    private byte Role;
    private final int ID;
    private static int currentID = 1;
}
