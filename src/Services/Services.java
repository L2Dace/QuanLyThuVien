/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Connection.ConnectLink;
import Type.bao;
import Type.sach;
import Type.tapChi;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Services {
    
    private ConnectLink sachLink, tapChiLink, baoLink;

    public Services() {
        sachLink = new ConnectLink();
        tapChiLink = new ConnectLink();
        baoLink = new ConnectLink();
        
    }
    
    public List<sach> getAllSach(){
        return sachLink.getAllSach();
    }
    public List<bao> getAllBao(){
        return baoLink.getAllBao();
    }
    public List<tapChi> getAllTapChi(){
        return tapChiLink.getAllTapChi();
    }
    
    public void addSach(sach Sach){
        sachLink.addSach(Sach);
    }
    public void addTapChi(tapChi TapChi){
        tapChiLink.addTapChi(TapChi);
    }
    public void addBao(bao Bao){
        baoLink.addBao(Bao);
    }
    
}
