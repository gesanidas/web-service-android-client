using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Linq;

namespace MyCompany.Models
{
    public static class SeedData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new MyCompanyContext(
                serviceProvider.GetRequiredService<DbContextOptions<MyCompanyContext>>()))
            {
                if (context.Employee.Any())
                {
                    return;   
                }

                context.Employee.AddRange(
                     new Employee
                     {
                         Name = "George Sanidas",
                         Email = "gesandias@gmail.com",
                         Password = "abc",
                         Title = "Accountant",
                         Phone = 2102812320
                     },

                     new Employee
                     {
                         Name = "Nick  Sanidas",
                         Email = "nick@gmail.com",
                         Password = "abc",
                         Title = "Developer",
                         Phone = 2102812320
                     },

                            new Employee
                            {
                                Name = "George Argiros",
                                Email = "argiros@gmail.com",
                                Password = "abc",
                                Title = "Accountant",
                                Phone = 2102812320
                            },

                           new Employee
                           {
                               Name = "George Michael",
                               Email = "gmac@gmail.com",
                               Password = "abc",
                               Title = "Manager",
                               Phone = 2102812320
                           }
                );
                context.SaveChanges();

                context.Skill.AddRange(
                 new Skill
                 {
                     EmployeeID = 1,
                     Description = "Microsoft Office",

                 },

                  new Skill
                  {
                      EmployeeID = 2,
                      Description = "Java",

                  },

               new Skill
               {
                   EmployeeID = 3,
                   Description = "Python",

               },

                    new Skill
                    {
                        EmployeeID = 4,
                        Description = "Web Apps",

                    }


);
                //context.SaveChanges();
            }
        }
    }
}

