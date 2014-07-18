package com.demo;
/**
 * 
 *
 *  @version ： 1.0
 *  
 *  @author  ： 苏若年              <a href="mailto:DennisIT@163.com">发送邮件</a>
 *    
 *  @since   ： 1.0        创建时间:    2013-4-7    下午01:52:49
 *     
 *  @function： TODO        
 *
 */
public class Medicine {

    private Integer id;
    private String name;
    private String function;
    
    
    public Medicine() {
        
    }
    
    
    public Medicine(Integer id, String name, String function) {
        super();
        this.id = id;
        this.name = name;
        this.function = function;
    }

    //getter and setter()    

    public String toString(){
        return this.id + "," +this.name + "," + this.function;
    }
}