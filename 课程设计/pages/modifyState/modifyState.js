// pages/modifyState/modifyState.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: [
      { name: '4', value: '离职' },
      { name: '6', value: '退休' },
    ]
  },

  radioChange(e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value)
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
    console.log("e.detail.value.employeeState: " + e.detail.value.employeeState);
    that.setData({
      employeeId: e.detail.value.employeeId,
      employeeState: e.detail.value.employeeState
    })
    wx.request({
      url: 'http://localhost:8082/weixin/superadmin/modifyemployee',
      data: {
        employeeId: e.detail.value.employeeId,
        employeeState: e.detail.value.employeeState
      },
      method: 'POST',
      header: {
        'content-type': 'application/json'
      },
      success: function (res) {
        console.log("办理成功！");
        wx.showToast({
          title: '办理成功！',
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
        console.log("办理失败！");
        wx.showToast({
          title: '办理失败！',
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