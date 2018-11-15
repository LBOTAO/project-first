package cn.happy.day02paper;

/**
 * author：  刘涛
 *
 * @create 2018-11-15 15:28
 */
public class Print {
    public Ink ink;
    public Paper paper;

    public void printInfo(){
        System.out.println("我正在使用"+ink.getColor()+"打印在"+paper.getPaper()+"上打印呵呵哒");
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }
}
