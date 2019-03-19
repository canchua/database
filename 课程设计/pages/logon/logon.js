// pages/logon/logon.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userid: 0,
    password: '',
    authority: 0,
    employeeId: 0,
    passWord: ''
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
    console.log('that.data.userid = ', that.data.userid);
    console.log('that.data.password = ', that.data.password);
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    console.log('e.detail.value.userid = ', e.detail.value.userid);
    console.log('e.detail.value.password = ', e.detail.value.password);
    // wx.navigateTo({
    //   url: 'http://localhost:8082/weixin/logon/userauthority',
    // })
    that.setData({
      employeeId: e.detail.value.userid,
      passWord: e.detail.value.password
    })
    console.log("that.data.employeeId: " + that.data.employeeId);
    wx.request({
      url: 'http://localhost:8082/weixin/logon/userauthority',
      data:{
        employeeId: e.detail.value.userid,
        passWord: e.detail.value.password,
        // authority: ''
      },
      method: 'GET',
      header:{
        'content-type': 'application/json'
      },
      success: function (res) {
        data: {
          authority: res.data
        }
        console.log(res.data);        
        // console.log("authority:" + that.data.authority);
        if(res.data == 1)
        {
          wx.navigateTo({
            url: '../userModifyPage/userModifyPage?employeeId=' + that.data.employeeId,
          })
        }
        else if(res.data == 2)
        {
          wx.navigateTo({
            url: '../adminSearchPage/adminSearchPage',
          })
        }
        else{
          wx.showToast({
            title: '登录账号或密码错误',
            duration: 0,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
          
        }
      },
      fail: function () {
        
      },
    })
    console.log('employeeId: ' + that.data.employeeId);
    console.log('passWord: ' + that.data.passWord);
  },

  forgetPassword: function () {
    wx.showModal({
      title: '联系管理员?',
      success(res) {
        if (res.confirm) {
          console.log('用户点击确定');
          wx.makePhoneCall({
            phoneNumber: '0000000' 
          })
        } else if (res.cancel) {
          wx.navigateBack({
            delta: 1,
          })
          console.log('用户点击取消')
        }
      }
    })
  }

})