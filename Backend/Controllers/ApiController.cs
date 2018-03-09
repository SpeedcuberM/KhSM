﻿using System;
using System.Linq;
using Backend.Data.Entities;
using Backend.Domain;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace Backend.Controllers
{
    [Route("api/[controller]")]
    [Produces("application/json")]
    public abstract class ApiController : Controller
    {
        private readonly UsersManager _usersManager;
        
        // ReSharper disable once MemberCanBePrivate.Global
        public Session Session { get; private set; }
        // ReSharper disable once UnusedMember.Global
        public new User User => Session?.User;

        protected ApiController(UsersManager usersManager)
        {
            _usersManager = usersManager;
        }

        public override void OnActionExecuting(ActionExecutingContext context)
        {
            base.OnActionExecuting(context);
         
            var authorization = Request.Headers["Authorization"].SingleOrDefault();

            Authenticate(authorization);
        }

        public bool IsMe(int userId)
        {
            return User?.Id == userId;
        }

        private void Authenticate(string sessionToken)
        {
            if (sessionToken == null) return;
            
            Session = _usersManager.FindSession(sessionToken) ?? throw new Exception("Authorization failed");
        }
    }
}