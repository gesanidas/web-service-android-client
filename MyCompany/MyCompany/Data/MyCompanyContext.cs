using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace MyCompany.Models
{
    public class MyCompanyContext : DbContext
    {
        public MyCompanyContext (DbContextOptions<MyCompanyContext> options)
            : base(options)
        {
        }

        public DbSet<MyCompany.Models.Employee> Employee { get; set; }
        public DbSet<MyCompany.Models.Skill> Skill { get; set; }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Employee>().ToTable("Employee");
            modelBuilder.Entity<Skill>().ToTable("Skill");
        }

    }
}
