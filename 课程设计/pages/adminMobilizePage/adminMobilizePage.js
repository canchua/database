// pages/adminMobilizePage/adminMobilizePage.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },


  formSubmit: function (e) {
    var that = this;
    // var employee = e.detail.value;
    console.log("e.detail.value: " + e.detail.value);
    console.log("e.detail.value.employeeId: " + e.detail.value.employeeId);
    console.log("e.detail.value.outDepartment: " + e.detail.value.outDepartment);
    that.setData({
      employeeId: e.detail.value.employeeId,
      transDate: e.detail.value.transDate,
      inDepartment: e.detail.value.inDepartment,
      outDepartment: e.detail.value.outDepartment,
      reason: e.detail.value.reason
    })
    wx.request({
      url: 'http://localhost:8082/weixin/transfer/addtransfer',
      data: {
        employeeId: e.detail.value.employeeId,
        transDate: e.detail.value.transDate,
        inDepartment: e.detail.value.inDepartment,
        outDepartment: e.detail.value.outDepartment,
        reason: e.detail.value.reason
      },
      method: 'POST',
      header: {
        'content-type': 'application/json'
      },
      success: function (res) {
        console.log("员工调动成功！");
        wx.showToast({
          title: '员工调动成功！',
          duration: 0,
          mask: true,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })
        wx.navigateBack({
        })
      },
      fail: function () {
        console.log("员工调动失败！");
        wx.showToast({
          title: '员工调动失败！',
          duration: 0,
          mask: true,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })

      },
    })
  }
})