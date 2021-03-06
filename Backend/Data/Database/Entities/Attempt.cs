﻿using Backend.Data.Entities;

namespace Backend.Data.Database.Entities
{
    public class Attempt
    {
        public int Id { get; set; }
        public Result Result { get; set; }
        public decimal? Time { get; set; }
    }
}