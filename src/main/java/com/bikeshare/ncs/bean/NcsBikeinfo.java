package com.bikeshare.ncs.bean;

public class NcsBikeinfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ncs_bikeinfo.id
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ncs_bikeinfo.bikeBrand
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    private String bikebrand;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ncs_bikeinfo.id
     *
     * @return the value of ncs_bikeinfo.id
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ncs_bikeinfo.id
     *
     * @param id the value for ncs_bikeinfo.id
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ncs_bikeinfo.bikeBrand
     *
     * @return the value of ncs_bikeinfo.bikeBrand
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public String getBikebrand() {
        return bikebrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ncs_bikeinfo.bikeBrand
     *
     * @param bikebrand the value for ncs_bikeinfo.bikeBrand
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public void setBikebrand(String bikebrand) {
        this.bikebrand = bikebrand == null ? null : bikebrand.trim();
    }
}