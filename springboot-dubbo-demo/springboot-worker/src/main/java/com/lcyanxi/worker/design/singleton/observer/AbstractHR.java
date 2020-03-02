package com.lcyanxi.worker.design.singleton.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcyanxi on 2019/11/19
 */

public abstract class  AbstractHR {

    // 订阅者
    protected List<ITalent> allTalents=new ArrayList<>();

    /**
     * 添加订阅者
     * @param talent 订阅者
     */
    public void addTalent(ITalent talent){
        allTalents.add(talent);
    }

    /**
     *  移除订阅者
     * @param talent 订阅者
     */
    public void removeTalent(ITalent talent){
        allTalents.remove(talent);
    }

    /**
     *  发布新的工作
     * @param job 新工作
     */
    public  abstract void publishJob(String job);
}
