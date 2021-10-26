package com.hwgif.example.bean;

import com.hwgif.common.util.XmlUtil;
import io.swagger.models.Xml;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description:  旧版本异步取数报文解析
 * date: 2020/5/22 16:41
 *
 * @author zuoqiwen
 */
@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dataExchangePackage")
public class DataExchangePackageUtil {
    private EnvelopeInfo envelopeInfo;
    private TransferInfo transferInfo;
    private ContentControl contentControl;
    private PackageInfo packageInfo;

    @Data
    @Accessors(chain = true)
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class TransferInfo {
        private String senderID;
        private String receiverID = "TAX";
        private String messageID;
        private String sourceMessageID = "";
        private String isRetry = "N";
        private String sendTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        public TransferInfo() {

        }

        public TransferInfo(TaxData taxData) {
            this.senderID = taxData.getBankaccount();
            this.messageID = "";
            this.sourceMessageID = taxData.getSqxh();
        }
    }

    @Data
    @Accessors(chain = true)
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EnvelopeInfo {
        private String sourceID;
        private String destinationID = "TAX";
        private String destinationAppID = "TAX";
        private String globalBusinessID = "";
        private String businessType = "BW_BUSINESS";


        public EnvelopeInfo() {

        }

        public EnvelopeInfo(TaxData taxData) {
            this.sourceID = taxData.getBankaccount();
            this.globalBusinessID = taxData.getSqxh();
        }
    }

    @Data
    @Accessors(chain = true)
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ContentControl {
        private Zip zip;
        private Encrypt encrypt;
        private Code code;

        public ContentControl() {
            this.zip = new Zip();
            this.encrypt = new Encrypt();
            this.code = new Code();

        }

        @Data
        @Accessors(chain = true)
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Zip {
            private boolean isZip;
            private String zipType;
            private boolean isEncrypt;
            private String encryptType;
            private boolean isCode;
            private String getCodeType;

        }

        @Data
        @Accessors(chain = true)
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Encrypt {

        }

        @Data
        @Accessors(chain = true)
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Code {

        }
    }

    @Data
    @Accessors(chain = true)
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class PackageInfo {
        private String sequence = "1";
        @XmlJavaTypeAdapter(value = CDATAAdapter.class)
        private String content;


        public PackageInfo() {

        }

        public PackageInfo(String xml) {
            this.content = xml;
        }
    }

    public DataExchangePackageUtil(TaxData taxData) {
        this.envelopeInfo = new EnvelopeInfo(taxData);
        this.transferInfo = new TransferInfo(taxData);
        this.contentControl = new ContentControl();
        this.packageInfo = new PackageInfo(XmlUtil.toXml(TaxData.class, taxData));
    }

    public DataExchangePackageUtil() {
        this.envelopeInfo = new EnvelopeInfo();
        this.transferInfo = new TransferInfo();
        this.contentControl = new ContentControl();
        this.packageInfo = new PackageInfo();
    }

    /**
     * 请求数据转换为xml
     *
     * @param taxData
     * @return
     */
    public static String dataToXml(TaxData taxData) {
        return XmlUtil.toXml(DataExchangePackageUtil.class, new DataExchangePackageUtil(taxData));

    }

    /**
     * xml转换为请求数据
     *
     * @param xml
     * @return
     */
    public static TaxData toData(String xml) {
        return XmlUtil.toObject(TaxData.class, XmlUtil.toObject(DataExchangePackageUtil.class, xml).packageInfo.content);

    }
}
