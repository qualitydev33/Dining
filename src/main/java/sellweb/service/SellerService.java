package sellweb.service;

import sellweb.dataobject.SellerInfo;


public interface SellerService {

    /**
     * Find seller information by open id
     * @param openid
     * @return the information of seller
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
