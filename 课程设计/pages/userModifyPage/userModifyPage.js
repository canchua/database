// pages/userModifyPage/userModifyPage.js
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
    var that = this;
    wx.request({
      url: 'http://localhost:8082/weixin/superadmin/getemployeebyid',
      method: 'GET',
      data: {
        employeeId: options.employeeId
      },
      success: function (res) {
        var theEmployee = options.employeeId;
        console.log("options.employeeId:" + options.employeeId);
        console.log("theEmployee: " + theEmployee);
        if (theEmployee == null) {
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            item: res.data.employee
            // employeeId: res.data.employeeId,
            // employeeName: res.data.employeeName,
            // job: res.data.job,
            // employeeState: res.data.employeeState,
            // joinTime: res.data.joinTime,
            // departmentId: res.data.departmentId
          });
          console.log("item: " + that.data.item);
          console.log("item.employeeId: " + that.data.item.employeeId);
        }
      }
    })
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

  toModifyPassword: function () {
    var that = this;
    wx.navigateTo({
      url: '../modifyPassword/modifyPassword?employeeId=' + that.data.employeeId,
    })
  },

  toModifyState: function () {
    var that = this;
    wx.navigateTo({
      url: '../modifyState/modifyState?employeeId=' + that.data.employeeId,
    })
  }

})