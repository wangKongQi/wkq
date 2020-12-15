package com.medcine.service.num.impl;

import com.medcine.base.entity.num.DoctorBO;
import com.medcine.base.entity.num.Numeral;
import com.medcine.base.entity.num.NumeralPageQO;
import com.medcine.base.entity.num.NumeralQO;
import com.medcine.dao.NumeralMapper;
import com.medcine.service.num.NumeralService;
import com.medcine.utils.common.CalendarUtils;
import com.medcine.utils.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/4 14:38
 */
@Service
public class NumeralServiceImpl implements NumeralService {

    @Resource
    private NumeralMapper numeralMapper;


    @Override
    @Async("asyncServiceExecutor")
    public Integer add(Numeral numeral) throws Exception {
        synchronized ("lock") {
            //获取排号
            NumeralQO qo = new NumeralQO();
            Date tomorrow = CalendarUtils.getTomorrow(numeral.getNumDate());
            qo.setNumDateEnd(tomorrow);
            BeanUtils.copyProperties(numeral, qo);
            Integer num = numeralMapper.getNum(qo);
            numeral.setNowNum(num + 1);
            return numeralMapper.insert(numeral);
        }
    }

    @Override
    public Integer getNum(NumeralQO qo) throws Exception {
        //doctor为1的时候，取全部
        return numeralMapper.getNum(qo);
    }

    @Override
    public PageVo<Numeral> pageQuery(NumeralPageQO qo) throws Exception {
        if (qo.getNumDate() != null) {
            qo.setNumDateEnd(CalendarUtils.getTomorrow(qo.getNumDate()));
        }
        PageVo<Numeral> pageVo = new PageVo<Numeral>().setCurrentAndSize(qo);
        pageVo.setRecords(numeralMapper.pageQuery(qo));
        pageVo.setTotal(numeralMapper.getCount(qo));
        return pageVo;
    }

    @Override
    public List<DoctorBO> getDoctorList(String orgNo, String departNo) {
        return numeralMapper.getDoctorList(orgNo, departNo);
    }
}
