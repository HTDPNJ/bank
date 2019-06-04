package com.hfut.service.impl;

import com.hfut.pojo.Account;
import com.hfut.pojo.Log;
import com.hfut.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class AccountServiceImpl implements AccountService {
    @Override
    public int transfer(Account accIn, Account accOut) throws IOException {
        InputStream is=Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        Account accOutSelect= session.selectOne("com.hfut.mapper.AccountMapper.selByAccnoPwd",accOut);
        if(accOutSelect!=null){
            if(accOutSelect.getBalance()>=accOut.getBalance()){
                Account accInselect=session.selectOne("com.hfut.mapper.AccountMapper.selByAccnoName",accIn);
                if(accInselect!=null){
                    accIn.setBalance(accOut.getBalance());
                    accOut.setBalance(-accOut.getBalance());
                    int index=session.update("com.hfut.mapper.AccountMapper.updBalanceAccno",accOut);
                    index+=session.update("com.hfut.mapper.AccountMapper.updBalanceAccno",accIn);
                    if(index==2){
                        Log log=new Log();
                        log.setAccIn(accIn.getAccno());
                        log.setAccOut(accOut.getAccno());
                        log.setMoney(accIn.getBalance());
                        session.insert("com.hfut.mapper.LogMapper.insLog",log);  //在数据库日志中存储转账信息
                        Logger logger= Logger.getLogger(AccountServiceImpl.class);
                        logger.info(log.getAccOut()+"给"+log.getAccIn()+"在"+new Date().toString()+"转账"+log.getMoney());
                        session.commit();
                        session.close();
                        return SUCCESS;
                    }else{
                        session.rollback();
                        session.close();
                        return ERROR;
                    }
                }else{
                    return ACCOUNT_NAME_NOT_MATCH;
                }
            }else{
                return ACCOUNT_BALANCE_NOT_ENOUGH;
            }
        }else{
            //账号和密码不匹配
            return ACCOUNT_PASSWORD_NOT_MATCH;
        }
    }
}
